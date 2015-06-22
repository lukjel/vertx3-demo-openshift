# vertx3-demo-openshift #
Simple demo for openshift and vertx3.

## How to proceed ##

1. Create an account in OpenShift [link](http://openshift.redhat.com)
2. Add your ssh keys (or create new one) to your account.
3. Install rhc tool [link](https://developers.openshift.com/en/managing-client-tools.html)
4. Create "demo" app using command: `rhc create-app demo https://raw.githubusercontent.com/vert-x3/vertx-openshift-cartridge/master/metadata/manifest.yml -s` (more details: [link](https://github.com/vert-x3/vertx-openshift-cartridge)). There should be clonned repository `demo` with some direcotries like `configuration` and `application`
5. Build this project `mvn clean install` from root dir for this project repository. 
6. Copy fat.jar (`target/*-fat.jar`) to `demo` repository to `application` directory.
7. Because it is CLUSTERed example add this line to a `vertx.env` file in `configuration` directory: `export HAZELCAST_CLUSTERING=true`
8. Commit and push all changes...: (check your current directory - should be main "demo" repository) `git add -A; git commit -m "initial"; git push;`
9. Check logs: `rhc tail demo -o "-n 200"`
10. Should works...