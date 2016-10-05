package com.zeroecks.core.conversion;

import com.zeroecks.core.domain.Player;
import com.zeroecks.core.resource.PlayerResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter implements Converter<Player, PlayerResource> {
    @Override
    public PlayerResource convert(Player player) {
        if (player == null) {
            return null;
        }

        final PlayerResource resource = new PlayerResource();
        resource.setId(player.getId());
        resource.setName(player.getName());
        resource.setHandle(player.getHandle());
        resource.setHuman(player.isHuman());
        return resource;
    }
}
