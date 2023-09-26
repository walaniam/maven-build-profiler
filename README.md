# maven-build-profiler
## Deployment
### Snapshot
https://central.sonatype.org/publish/publish-maven/#performing-a-snapshot-deployment
### Release
https://central.sonatype.org/publish/publish-maven/#performing-a-release-deployment

In case of staging issues:
```shell
export MAVEN_OPTS="--add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.text=ALL-UNNAMED --add-opens=java.desktop/java.awt.font=ALL-UNNAMED"
```