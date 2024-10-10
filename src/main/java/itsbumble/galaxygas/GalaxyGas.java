package itsbumble.galaxygas;

import net.fabricmc.api.ModInitializer;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GalaxyGas implements ModInitializer {
	public static final String MOD_ID = "galaxygas";

	// Galaxy gas effect component
	public static final FoodComponent GALAXY_GAS_EFFECTS = new FoodComponent.Builder()
			.alwaysEdible() // Can be eaten even when not hungry
			.snack() // Declares it as a snack
			.statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 30 * 20, 255), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 30 * 20, 30), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 30 * 20, 30), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 30 * 20, 30), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 30 * 20, 30), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.POISON, 8 * 20, 30), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 2 * 20, 30), 1.0f)
			.saturationModifier(0.1f)  // Minimal saturation
			.nutrition(-4)  // Reduces 4 hunger points (2 hunger bars)

			.build();
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	//SOUNDS
	public static final Identifier GALAXY_GAS_SOUND = Identifier.of("galaxygas:galaxy_gas_sound");
	public static SoundEvent SOUNDEVENT = SoundEvent.of(GALAXY_GAS_SOUND);



	// Initialize item with effects
	public static final Item CUSTOM_ITEM = new GalaxyGasItem(new Item.Settings().food(GalaxyGas.GALAXY_GAS_EFFECTS));


	@Override

	public void onInitialize() {
		// For versions below 1.21, please replace ''Identifier.of'' with ''new Identifier''
		Registry.register(Registries.ITEM, Identifier.of("galaxygas", "galaxygas"), CUSTOM_ITEM);
		Registry.register(Registries.SOUND_EVENT, GalaxyGas.GALAXY_GAS_SOUND, SOUNDEVENT);
		// nitrus log
		LOGGER.info("Can I have the Nitrus today?");
		LOGGER.warn("No, you can't!");
	}
}

