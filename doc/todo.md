Direction
---

# Deploy

how to deploy:

```shell
mvn clean deploy -DskipTests -P sonatype-oss-release
```

登录 [oss.sonatype.org](https://oss.sonatype.org/#stagingRepositories) 完成发布