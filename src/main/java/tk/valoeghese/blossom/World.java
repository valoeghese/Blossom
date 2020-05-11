package tk.valoeghese.blossom;

import static tk.valoeghese.blossom.InternalUtils.*;

import io.github.antiquitymc.nbt.CompoundTag;
import io.github.antiquitymc.nbt.TagType;

/**
 * A minecraft world. Create with the given {@link World.create create} method.
 */
public abstract class World {
	World(String name, boolean allowCheats, boolean hardcore, long seed) {
		this.name = name;
		this.allowCheats = allowCheats;
		this.hardcore = hardcore;
		this.seed = seed;
	}

	String name;
	boolean allowCheats;
	boolean hardcore;
	long seed;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * Creates a new {@link World} instance.
	 * @param name the name of the world.
	 * @param allowCheats whether cheats are enabled.
	 * @param hardcore whether the world is hardcore.
	 * @param seed seed.
	 * @return a new world instance.
	 */
	public static World create(String name, boolean allowCheats, boolean hardcore, long seed) {
		return new WorldImpl(name, allowCheats, hardcore, seed);
	}
}

final class WorldImpl extends World implements Serialisable {
	WorldImpl(String name, boolean allowCheats, boolean hardcore, long seed) {
		super(name, allowCheats, hardcore, seed);
	}

	@Override
	public CompoundTag toTag() {
		CompoundTag data = compound();

		CompoundTag dataPacks = compound();
		dataPacks.put("Disabled", list(TagType.Standard.STRING));
		dataPacks.put("Enabled", stringList("vanilla"));

		data.put("DataPacks", dataPacks);
		data.putString("LevelName", this.name);
		data.putBoolean("allowCommands", this.allowCheats);
		data.putBoolean("hardcore", this.hardcore);
		data.putLong("RandomSeed", this.seed);

		return compound("Data", data);
	}

	@Override
	public void fromTag(CompoundTag tag) {
		CompoundTag data = tag.getSubTag("Data");
		this.name = data.getString("LevelName");
		this.allowCheats = data.getBoolean("allowCommands", false);
		this.hardcore = data.getBoolean("hardcore", false);
		this.seed = data.getLong("RandomSeed");
	}
}