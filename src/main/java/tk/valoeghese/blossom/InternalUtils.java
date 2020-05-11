package tk.valoeghese.blossom;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.github.antiquitymc.nbt.CompoundTag;
import io.github.antiquitymc.nbt.ListTag;
import io.github.antiquitymc.nbt.StringTag;
import io.github.antiquitymc.nbt.Tag;
import io.github.antiquitymc.nbt.TagType;

final class InternalUtils {
	static CompoundTag compound() {
		return new CompoundTag();
	}

	static CompoundTag compound(String name, Tag value) {
		CompoundTag result = compound();
		result.put(name, value);
		return result;
	}

	static <T extends Tag> ListTag<T> list(TagType type) {
		return new ListTag<>(type);
	}

	static ListTag<StringTag> stringList(String... strings) {
		return new ListTag<>(
				Stream.of(strings)
				.map(StringTag::new)
				.collect(Collectors.toList()));
	}
}
