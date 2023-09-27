# maven-build-profiler
## About
Maven Build Profiler, built on top of https://github.com/khmarbaise/maven-buildtime-profiler/releases/tag/maven-buildtime-profiler-0.2.0

## How to use it
In your project create `.mvn/extensions.xml` file with contents:
```xml
<extensions xmlns="http://maven.apache.org/EXTENSIONS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/EXTENSIONS/1.0.0 http://maven.apache.org/xsd/core-extensions-1.0.0.xsd">
  <extension>
    <groupId>io.github.walaniam</groupId>
    <artifactId>maven-build-profiler</artifactId>
    <version>0.0.1</version>
  </extension>
</extensions>
```

## For developers
### Snapshot
https://central.sonatype.org/publish/publish-maven/#performing-a-snapshot-deployment
### Release
https://central.sonatype.org/publish/publish-maven/#performing-a-release-deployment

In case of staging issues:
```shell
export MAVEN_OPTS="--add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.text=ALL-UNNAMED --add-opens=java.desktop/java.awt.font=ALL-UNNAMED"
```

#### Sync to central
In case not automated follow https://central.sonatype.org/publish/publish-maven/#manually-releasing-the-deployment-to-the-central-repository
or from UI https://central.sonatype.org/publish/release/#locate-and-examine-your-staging-repository
