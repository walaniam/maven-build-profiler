package walaniam.maven.profiler;

import com.soebes.maven.extensions.BuildTimeProfiler;
import org.apache.maven.execution.MavenExecutionResult;
import org.eclipse.aether.RepositoryEvent;
import org.eclipse.aether.repository.ArtifactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@Singleton
public class MavenBuildProfiler extends BuildTimeProfiler {

    private static final Logger log = LoggerFactory.getLogger(MavenBuildProfiler.class);

    private final Map<RepositoryInfo, List<ArtifactInfo>> downloaded = new HashMap<>();

    @Override
    public void onEvent(Object event) throws Exception {
        super.onEvent(event);
        if (event instanceof RepositoryEvent) {
            onRepositoryEvent((RepositoryEvent) event);
        } else if (event instanceof MavenExecutionResult) {
            onExecutionResultEvent((MavenExecutionResult) event);
        }
    }

    private void onExecutionResultEvent(MavenExecutionResult event) {
        log.debug("Handling execution result event: {}", event);
        log.info("------------------------------------------------------------------------");
        log.info("Artifact Download Sources");
        downloaded.keySet().forEach(repositoryInfo -> {
            log.info("Repository: {}", repositoryInfo.getKey());
            downloaded.get(repositoryInfo).stream()
                .map(ArtifactInfo::getKey)
                .map(it -> " " + it)
                .forEach(log::info);
        });
    }

    private void onRepositoryEvent(RepositoryEvent event) {
        log.debug("Handling repository event: {}", event);
        RepositoryEvent.EventType type = event.getType();
        switch (type) {
            case ARTIFACT_DOWNLOADED:
                handleDownloaded(event.getRepository(), new ArtifactInfo(event.getArtifact()));
                break;
            case METADATA_DOWNLOADED:
                handleDownloaded(event.getRepository(), new ArtifactInfo(event.getMetadata()));
                break;
            default:
                log.debug("onRepositoryEvent {}", type);
                break;
        }
    }

    private synchronized void handleDownloaded(ArtifactRepository repository,
                                               ArtifactInfo artifactInfo) {
        List<ArtifactInfo> artifacts = downloaded.computeIfAbsent(
            new RepositoryInfo(repository), ignore -> new ArrayList<>()
        );
        artifacts.add(artifactInfo);
    }
}
