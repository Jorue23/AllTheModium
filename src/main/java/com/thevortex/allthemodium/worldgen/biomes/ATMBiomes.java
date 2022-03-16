package com.thevortex.allthemodium.worldgen.biomes;

import com.thevortex.allthemodium.AllTheModium;
import com.thevortex.allthemodium.reference.Reference;
import com.thevortex.allthemodium.worldgen.ATMPlacedFeature;
import com.thevortex.allthemodium.worldgen.carvers.ATMCarvers;
import net.allthemods.alltheores.worldgen.ATOPlacedFeatures;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ATMBiomes {

    public static Biome The_Other;
    public static Biome Basalt_Deltas;
    public static Biome Crimson_Forest;
    public static Biome Desert;
    public static Biome Desert_Hills;
    public static Biome Soul_Sand_Valley;
    public static Biome Warped_Forest;

    public static final TagKey<Biome> THE_OTHER = register("the_other");
    public static final TagKey<Biome> BASALT_DELTAS = register("basalt_deltas");
    public static final TagKey<Biome> CRIMSON_FOREST = register("crimson_forest");
    public static final TagKey<Biome> DESERT = register("desert");
    public static final TagKey<Biome> DESERT_HILLS = register("desert_hills");
    public static final TagKey<Biome> SOUL_SAND_VALLEY = register("soul_sand_valley");
    public static final TagKey<Biome> WARPED_FOREST = register("warped_forest");


    private static TagKey<Biome> register(String names) {
        return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Reference.MOD_ID,names));
    }

    public static void addDefaultCarvers(BiomeGenerationSettings.Builder builder) {
        builder.addCarver(GenerationStep.Carving.AIR , Carvers.NETHER_CAVE);
        builder.addCarver(GenerationStep.Carving.AIR , Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR , Carvers.CANYON);
    }

    public static void addDefaultOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_ALUMINIUM);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_LEAD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_NICKEL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_OSMIUM);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_PLATINUM);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_SILVER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_TIN);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_URANIUM);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATOPlacedFeatures.ORE_ZINC);

        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_COAL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_COPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_DIAMOND);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_EMERALD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_GOLD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_IRON);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_LAPIS);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_QUARTZ);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,ATMPlacedFeature.OTHER_ORE_REDSTONE);
    }

    public static Biome mining() {
       return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .biomeCategory(Biome.BiomeCategory.NONE)
                .mobSpawnSettings(new MobSpawnSettings.Builder().build())
                .temperature(1.0f)
                .downfall(0f)
                .specialEffects(new BiomeSpecialEffects.Builder().fogColor(12341234).waterColor(4159204).waterFogColor(329011).skyColor(7254527).foliageColorOverride(1787717).grassColorOverride(9470000).build())
                .generationSettings(new BiomeGenerationSettings.Builder().build()).build().setRegistryName("mining");
    }
    public static Biome the_other() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(3343107).waterColor(3343107).waterFogColor(3343107).skyColor(3343107).foliageColorOverride(1787717).grassColorOverride(1787717).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 100, 5, 10)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BLAZE, 120, 3, 5)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 140, 8, 12)).build();

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).mobSpawnSettings(mobSpawnInfo).temperature(1.5f).downfall(0f).specialEffects(effects).generationSettings(biomeGenerationSettings.build()).build().setRegistryName("the_other");
    }

    public static Biome basalt_deltas() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(6840176).waterColor(3343107).waterFogColor(3343107).skyColor(3343107).foliageColorOverride(1787717).grassColorOverride(1787717).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addLushCavesVegetationFeatures(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, NetherPlacements.BASALT_BLOBS);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, NetherPlacements.SMALL_BASALT_COLUMNS);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, NetherPlacements.LARGE_BASALT_COLUMNS);


        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.MAGMA_CUBE, 100, 5, 10)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BLAZE, 120, 3, 5)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 140, 8, 12)).build();

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).mobSpawnSettings(mobSpawnInfo).temperature(2.0f).downfall(0f).specialEffects(effects).generationSettings(biomeGenerationSettings.build()).build().setRegistryName("basalt_deltas");
    }
    public static Biome crimson_forest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(3343107).waterColor(3343107).waterFogColor(3343107).skyColor(3343107).foliageColorOverride(1787717).grassColorOverride(1787717).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 100, 5, 10)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BLAZE, 120, 3, 5)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 140, 8, 12)).build();

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).mobSpawnSettings(mobSpawnInfo).temperature(1.3f).downfall(0f).specialEffects(effects).generationSettings(biomeGenerationSettings.build()).build().setRegistryName("crimson_forest");
    }
    public static Biome desert() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(3343107).waterColor(3343107).waterFogColor(3343107).skyColor(3343107).foliageColorOverride(1787717).grassColorOverride(1787717).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 100, 5, 10)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 120, 3, 5)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 140, 8, 12)).build();

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).mobSpawnSettings(mobSpawnInfo).temperature(1.8f).downfall(0f).specialEffects(effects).generationSettings(biomeGenerationSettings.build()).build().setRegistryName("desert");
    }
    public static Biome desert_hills() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(3343107).waterColor(3343107).waterFogColor(3343107).skyColor(3343107).foliageColorOverride(1787717).grassColorOverride(1787717).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 100, 5, 10)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 120, 3, 5)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 140, 8, 12)).build();

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).mobSpawnSettings(mobSpawnInfo).temperature(1.7f).downfall(0f).specialEffects(effects).generationSettings(biomeGenerationSettings.build()).build().setRegistryName("desert_hills");
    }
    public static Biome soul_sand_valley() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(3343107).waterColor(3343107).waterFogColor(3343107).skyColor(3343107).foliageColorOverride(1787717).grassColorOverride(1787717).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 100, 5, 10)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 120, 3, 3)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 140, 8, 12)).build();

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).mobSpawnSettings(mobSpawnInfo).temperature(1.1f).downfall(0f).specialEffects(effects).generationSettings(biomeGenerationSettings.build()).build().setRegistryName("soul_sand_valley");
    }
    public static Biome warped_forest() {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(1705242).waterColor(3343107).waterFogColor(3343107).skyColor(1705242).foliageColorOverride(1787717).grassColorOverride(1787717).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addDripstone(biomeGenerationSettings);
        addDefaultCarvers(biomeGenerationSettings);

        MobSpawnSettings mobSpawnInfo = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 100, 5, 10)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 160, 3, 7)).addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN_BRUTE, 140, 8, 12)).build();

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).mobSpawnSettings(mobSpawnInfo).temperature(1.2f).downfall(0f).specialEffects(effects).generationSettings(biomeGenerationSettings.build()).build().setRegistryName("warped_forest");
    }
    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        event.getRegistry().register(mining());
        event.getRegistry().register(the_other());
        event.getRegistry().register(basalt_deltas());
        event.getRegistry().register(crimson_forest());
        event.getRegistry().register(desert());
        event.getRegistry().register(desert_hills());
        event.getRegistry().register(soul_sand_valley());
        event.getRegistry().register(warped_forest());

    }
}
