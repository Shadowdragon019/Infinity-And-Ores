
package net.mcreator.infinityores.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityClassification;

import net.mcreator.infinityores.entity.GlomperEntity;
import net.mcreator.infinityores.entity.CrawlantEntity;
import net.mcreator.infinityores.block.GlitchedSoilBlock;
import net.mcreator.infinityores.InfinityAndOresModElements;

@InfinityAndOresModElements.ModElement.Tag
public class SpikyPlateauBiome extends InfinityAndOresModElements.ModElement {
	@ObjectHolder("infinity_and_ores:spiky_plateau")
	public static final CustomBiome biome = null;
	public SpikyPlateauBiome(InfinityAndOresModElements instance) {
		super(instance, 319);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.2f).temperature(0f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(GlitchedSoilBlock.block.getDefaultState(),
							GlitchedSoilBlock.block.getDefaultState(), GlitchedSoilBlock.block.getDefaultState())));
			setRegistryName("spiky_plateau");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(CrawlantEntity.entity, 15, 3, 5));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(GlomperEntity.entity, 10, 1, 3));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -16777216;
		}
	}
}
