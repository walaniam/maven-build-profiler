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

#### Sync to central
In case not automated follow https://central.sonatype.org/publish/publish-maven/#manually-releasing-the-deployment-to-the-central-repository
or from UI https://central.sonatype.org/publish/release/#locate-and-examine-your-staging-repository