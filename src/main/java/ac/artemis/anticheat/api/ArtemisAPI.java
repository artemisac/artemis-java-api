package ac.artemis.anticheat.api;

import cc.ghast.packet.nms.ProtocolVersion;

import java.util.UUID;

public interface ArtemisAPI {
    ProtocolVersion getVersion(UUID uuid);
}
