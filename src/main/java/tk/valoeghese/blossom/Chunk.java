package tk.valoeghese.blossom;

import io.github.antiquitymc.nbt.CompoundTag;
import static tk.valoeghese.blossom.InternalUtils.*;

public class Chunk implements Serialisable {
	private Section[] sections = new Section[17];

	@Override
	public CompoundTag toTag() {
		CompoundTag data = compound();
		data.put("Sections", compoundList(this.sections));

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fromTag(CompoundTag tag) {
		// TODO Auto-generated method stub
		
	}
	
}