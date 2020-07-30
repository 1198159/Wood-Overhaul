package com.I198159.util;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Set;
import java.util.stream.Stream;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.SignType;

public class CustomSignType extends SignType {
    private static final Set<SignType> VALUES = new ObjectArraySet();
    public static final SignType BLACKWOOD = register(new CustomSignType("blackwood"));
    /*public static final SignType SPRUCE = register(new CustomSignType("spruce"));
    public static final SignType BIRCH = register(new CustomSignType("birch"));
    public static final SignType ACACIA = register(new CustomSignType("acacia"));
    public static final SignType JUNGLE = register(new CustomSignType("jungle"));
    public static final SignType DARK_OAK = register(new CustomSignType("dark_oak"));
    public static final SignType CRIMSON = register(new CustomSignType("crimson"));
    public static final SignType WARPED = register(new CustomSignType("warped"));*/

    public CustomSignType(String name) {
        super(name);
    }

    private static SignType register(SignType type) {
        VALUES.add(type);
        return type;
    }

    @Environment(EnvType.CLIENT)
    public static Stream<SignType> stream() {
        return VALUES.stream();
    }

    public static SignType getSignFromID(String id){
        final SignType[] t = new SignType[1];
        VALUES.stream().filter(s -> s.getName().equals(id)).findFirst().ifPresent(s -> t[0] = s);
        return t[0] != null ? t[0] : register(new CustomSignType(id));
    }
}
