package walaniam.maven.profiler;

import com.soebes.maven.extensions.BuildTimeProfiler;
import org.apache.maven.execution.MavenExecutionResult;
import org.eclipse.aether.RepositoryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class MavenBuildProfiler extends BuildTimeProfiler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuildTimeProfiler.class);

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
        LOGGER.debug("Handling execution result event: {}", event);
    }

    private void onRepositoryEvent(RepositoryEvent repositoryEvent) {
        LOGGER.debug("Handling repository event: {}", repositoryEvent);
        RepositoryEvent.EventType type = repositoryEvent.getType();
        switch (type) {
            case ARTIFACT_DOWNLOADING:
                break;
            case ARTIFACT_DOWNLOADED:
                break;
            case ARTIFACT_DEPLOYING:
                break;
            case ARTIFACT_DEPLOYED:
                break;
            case ARTIFACT_INSTALLING:
                break;
            case ARTIFACT_INSTALLED:
                break;
            case METADATA_DEPLOYING:
                break;
            case METADATA_DEPLOYED:
                break;
            case METADATA_DOWNLOADING:
                break;
            case METADATA_DOWNLOADED:
                break;
            case METADATA_INSTALLING:
                break;
            case METADATA_INSTALLED:
                break;

            case ARTIFACT_RESOLVING:
            case ARTIFACT_RESOLVED:
            case ARTIFACT_DESCRIPTOR_INVALID:
            case ARTIFACT_DESCRIPTOR_MISSING:
            case METADATA_RESOLVED:
            case METADATA_RESOLVING:
            case METADATA_INVALID:
                // Those events are not recorded.
                break;

            default:
                LOGGER.warn("onRepositoryEvent {}", type);
                break;
        }
    }
}
