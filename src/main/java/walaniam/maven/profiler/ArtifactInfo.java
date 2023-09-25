package walaniam.maven.profiler;

import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.metadata.Metadata;

import java.util.Objects;

public class ArtifactInfo {

    private final String groupId;
    private final String artifactId;
    private final String version;
    private String classifier;
    private String extension;
    private String type;

    public ArtifactInfo(Artifact artifact) {
        this.groupId = artifact.getGroupId();
        this.artifactId = artifact.getArtifactId();
        this.version = artifact.getVersion();
        this.classifier = artifact.getClassifier();
        this.extension = artifact.getExtension();
    }

    public ArtifactInfo(Metadata metadata) {
        this.groupId = metadata.getGroupId();
        this.artifactId = metadata.getArtifactId();
        this.version = metadata.getVersion();
        this.type = metadata.getType();
    }

    public String getKey() {
        return String.format("%s:%s:%s::%s", groupId, artifactId, version, extension);
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }

    public String getClassifier() {
        return classifier;
    }

    public String getExtension() {
        return extension;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtifactInfo that = (ArtifactInfo) o;
        return groupId.equals(that.groupId) && artifactId.equals(that.artifactId) && version.equals(that.version)
            && Objects.equals(classifier, that.classifier) && Objects.equals(extension, that.extension)
            && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, artifactId, version, classifier, extension, type);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArtifactInfo{");
        sb.append("groupId='").append(groupId).append('\'');
        sb.append(", artifactId='").append(artifactId).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append(", classifier='").append(classifier).append('\'');
        sb.append(", extension='").append(extension).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
