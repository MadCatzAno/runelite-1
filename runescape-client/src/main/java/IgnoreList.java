import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public class IgnoreList extends UserList {
	@ObfuscatedName("rj")
	@ObfuscatedGetter(
		intValue = -1974595173
	)
	static int field3620;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Lmu;"
	)
	final LoginType loginType;

	@ObfuscatedSignature(
		descriptor = "(Lmu;)V"
	)
	public IgnoreList(LoginType var1) {
		super(400); // L: 12
		this.loginType = var1;
	} // L: 14

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(B)Ljc;",
		garbageValue = "35"
	)
	User newInstance() {
		return new Ignored(); // L: 17
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(IB)[Ljc;",
		garbageValue = "-19"
	)
	User[] newTypedArray(int var1) {
		return new Ignored[var1]; // L: 21
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(Lkf;IB)V",
		garbageValue = "-55"
	)
	public void read(Buffer var1, int var2) {
		while (true) {
			if (var1.offset < var2) { // L: 25
				int var3 = var1.readUnsignedByte(); // L: 26
				boolean var4 = (var3 & 1) == 1; // L: 27
				Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType); // L: 28
				Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.loginType); // L: 29
				var1.readStringCp1252NullTerminated(); // L: 30
				if (var5 != null && var5.hasCleanName()) { // L: 31
					Ignored var7 = (Ignored)this.getByCurrentUsername(var5); // L: 32
					if (var4) { // L: 33
						Ignored var8 = (Ignored)this.getByCurrentUsername(var6); // L: 34
						if (var8 != null && var8 != var7) { // L: 35
							if (var7 != null) { // L: 36
								this.remove(var8); // L: 37
							} else {
								var7 = var8; // L: 40
							}
						}
					}

					if (var7 != null) { // L: 44
						this.changeName(var7, var5, var6); // L: 45
						continue;
					}

					if (this.getSize() < 400) { // L: 47
						int var9 = this.getSize(); // L: 48
						var7 = (Ignored)this.addLast(var5, var6); // L: 49
						var7.id = var9; // L: 50
					}
					continue;
				}

				throw new IllegalStateException(); // L: 53
			}

			return; // L: 54
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(I)[Lij;",
		garbageValue = "1485577751"
	)
	static GameBuild[] method5182() {
		return new GameBuild[]{GameBuild.LIVE, GameBuild.WIP, GameBuild.RC, GameBuild.BUILDLIVE}; // L: 13
	}
}
