package com.zeroecks.core.conversion;

import com.zeroecks.core.domain.Player;
import com.zeroecks.core.resource.PlayerResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlayerResourceConverter implements Converter<PlayerResource, Player> {
    @Override
    public Player convert(PlayerResource resource) {
        if (resource == null) {
            return null;
        }

        final Player player = new Player();
        player.setId(resource.getId());
        player.setName(resource.getName());
        player.setHandle(resource.getHandle());
        player.setHuman(resource.isHuman());
        return player;
    }
}
