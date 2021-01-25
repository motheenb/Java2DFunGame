package org.game.client.sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sprite {

    private final BufferedImage sprite;

    public Sprite(final BufferedImage sprite) {
        this.sprite = sprite;
    }

    public static BufferedImage loadSprite(final String path) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(new File(path));
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return sprite;
    }

    public BufferedImage get() {
        return sprite;
    }

    public BufferedImage getSprite() {
        return sprite;
    }
}
