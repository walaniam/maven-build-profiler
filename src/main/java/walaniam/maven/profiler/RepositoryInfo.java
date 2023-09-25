package walaniam.maven.profiler;

import org.eclipse.aether.repository.ArtifactRepository;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;

import java.util.Objects;
import java.util.Optional;

public class RepositoryInfo {

    private final String key;

    public RepositoryInfo(ArtifactRepository repository) {
        final String location;
        if (repository instanceof RemoteRepository) {
            RemoteRepository remote = (RemoteRepository) repository;
            location = String.format("%s (%s)", repository.getId(), remote.getUrl());
        } else if (repository instanceof LocalRepository) {
            LocalRepository local = (LocalRepository) repository;
            String baseDir = Optional.ofNullable(local.getBasedir()).map(String::valueOf).orElse("");
            location = String.format("%s (%s)", repository.getId(), baseDir);
        } else {
            location = repository.toString();
        }
        this.key = location;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepositoryInfo)) return false;
        RepositoryInfo that = (RepositoryInfo) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RepositoryInfo{");
        sb.append("key='").append(key).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
