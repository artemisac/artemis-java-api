package ac.artemis.anticheat.api;

import ac.artemis.anticheat.api.listener.VerboseListener;
import cc.ghast.packet.nms.ProtocolVersion;

import java.util.UUID;

public interface ArtemisAPI {
    ProtocolVersion getVersion(UUID uuid);

    void addVerboseListener(VerboseListener verboseListener);

    void removeVerboseListener(VerboseListener verboseListener);

    void clearVerboseListeners();
}
