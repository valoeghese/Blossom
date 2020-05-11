package tk.valoeghese.blossom;

import static tk.valoeghese.blossom.InternalUtils.compound;
import static tk.valoeghese.blossom.InternalUtils.compoundList;

import io.github.antiquitymc.nbt.CompoundTag;

public class Chunk implements Serialisable {
	private Section[] sections = new Section[16];

	@Override
	public CompoundTag toTag() {
		CompoundTag data = compound();
		data.put("Sections", compoundList(new BlankSection(), this.sections));

		CompoundTag result = compound();
		result.put("Level", data);
		result.putInt("DataVersion", 2230);
		return result;
	}

	@Override
	public void fromTag(CompoundTag tag) {
		// TODO Auto-generated method stub
		
	}

}

class Section implements Serialisable {

	@Override
	public CompoundTag toTag() {
		CompoundTag result = compound();
		return result;
	}

	@Override
	public void fromTag(CompoundTag tag) {
		// TODO Auto-generated method stub
		
	}
	
}

class BlankSection extends Section {
	
}