package yourmod.name.here.api;

import at.petrak.hexcasting.api.spell.math.HexPattern;

public class HexPatternRenderHolder {
    HexPattern pattern;
    int lifetime;

    public HexPatternRenderHolder(HexPattern pattern, int lifetime) {
        this.pattern = pattern;
        this.lifetime = lifetime;
    }

    public HexPattern pattern() {
        return pattern;
    }

    public int lifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public void tick() {
        lifetime--;
    }

}
