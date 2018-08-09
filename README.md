# JR

# Research about how to deploy java application, using Travis.

There are some steps that you have to do in order to have Travis CI set, like the folowing.

# Setup SSH encryption key
1. Generate a dedicated SSH key (it is easier to isolate and to revoke);
2. Encrypt the private key to make it readable only by Travis CI (so as we can commit safely too!);
3. Copy the public key onto the remote SSH host;
4. Cleanup after unnecessary files;
5. Stage the modified files into Git.

Which translates into:

        ssh-keygen -t rsa -b 4096 -C 'build@travis-ci.org' -f ./deploy_rsa
        travis encrypt-file deploy_rsa --add
        ssh-copy-id -i deploy_rsa.pub <ssh-user>@<deploy-host>

        rm -f deploy_rsa deploy_rsa.pub
        git add deploy_rsa.enc .travis.yml

# Setup SSH decryption in Travis job
We still need to setup a few things before we are able to enact anything:
1. Preventing the SSH interactive prompt when connecting to a host for the first time (which means, for each build);
2. Decrypting the encrypted SSH private key;
3. Adding the key to the current ssh-agent to make any SSH-based command agnostic to the private key location.

        addons:
        ssh_known_hosts: <deploy-host>

        before_deploy:
        - openssl aes-256-cbc -K $encrypted_<...>_key -iv $encrypted_<...>_iv -in deploy_rsa.enc -out /tmp/deploy_rsa -d
        - eval "$(ssh-agent -s)"
        - chmod 600 /tmp/deploy_rsa
        - ssh-add /tmp/deploy_rsa

*Now it's time to deploy.*
# Travis Deploy Script

The way of deploying is to use the deploy script lifecycle event.

*.travis.yml*

    deploy:
        provider: script
        skip_cleanup: true
        script: rsync -r --delete-after --quiet $TRAVIS_BUILD_DIR/<dir> <ssh-user>@<deploy-host>:path/to/files
        on:
            branch: master

*dir* is the folder you want to recursively upload remotely.

skip_cleanup is kind of mandatory otherwise Travis resets the git directory state.

In this case if you want to deploy only when new modifications land on the master branch but you might want to deploy against different conditions too.
You can even run several deploy commands, to push content and to index it in a search engine:

*.travis.yml*

    deploy:
    - provider: script
        skip_cleanup: true
        script: npm run deploy
        on:
        branch: master
    - provider: script
        skip_cleanup: true
        script: npm run index-content
        on:
        branch: master

# Conslusion

This document is done in order to make you to understand the workflow of a custom deployment with Travis CI. 

You can now deploy several times a day without much more effort than merging a pull request.
