package tk.valoeghese.blossom;

import io.github.antiquitymc.nbt.CompoundTag;

interface Serialisable {
	CompoundTag toTag();
	void fromTag(CompoundTag tag);
}
