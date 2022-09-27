# jrmapi
jrmapi is a wrapper over the REST Cloud API for the reMarkable e-paper tablet implemented in Java11. It allows the access to the reMarkable files from a Java application via an easy-to-use API.

It can be downloaded from Maven Central:

```xml
<dependency>
    <groupId>es.jlarriba</groupId>
    <artifactId>jrmapi</artifactId>
    <version>0.7</version>
</dependency>
```

# usage
It reads the auth tokens from the ~/.rmapi file stored by rmapi with the usertoken and the devicetoken.

So, to use this API, first download and install rmapi, start it for the first time, associate it to your remarkable account. It will generate the .rmapi file and from then, you can use it to traverse your remarkable cloud with jrmapi.

# build
It can be build with Maven:

```
mvn package
```

However, it uses a custom version of the zip4j library that must be in your local repository. Build zip4j from: https://github.com/jlarriba/zip4j, install it in your local repository and run `mvn package`.

# api support
- [x] authentication
- [x] list documents
- [x] download a pdf (inside a zip)
- [x] download an epub (inside a zip)
- [x] extract the document from the downloaded zip file and rename it correctly
- [x] create new directory
- [x] upload a pdf
- [x] upload an epub
- [ ] move a file
- [x] delete an entry (document or directory)
- [ ] improved error control
- [ ] add tests
- [ ] provide javadoc documentation

# thanks
Many thanks to the incredible https://github.com/juruen/rmapi project, it provides a lot of insight. The documents compiled in https://github.com/splitbrain/ReMarkableAPI are also a must for reMarkable API development.

# disclaimer
The project is provided as-is, without warranty or support. The usage of the reMarkable Cloud API is

The author(s) and contributor(s) are not associated with reMarkable AS, Norway. reMarkable is a registered trademark of reMarkable AS in some countries. Please see https://remarkable.com for their product.
