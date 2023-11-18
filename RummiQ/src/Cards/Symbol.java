package Cards;

import java.util.Map;

public class Symbol{ // Oliver: Cambié nombre y color de private a public final,
	// puesto que, además de que deben ser accesibles, no se espera que se
	// modifiquen durante todo el programa.
	public final Name name;
	
	public Symbol() { this.name = Name.nullsym; }
	public Symbol(Name name) { this.name = name; }
	public Symbol(String name) { this.name = decode.get(name.toLowerCase()); }
	public String nameStr() { return strDecode.get(name); }
	
	public String symbolPic()
	{
		if (name == Name.nullsym) return "Transparent.png";
		return picDecode.get(name) + ".png";
	}
	
	public enum Name {spades, clovers, hearts, diamonds, nullsym};
	
	private static final Map<String, Name> decode = Map.of(
		"picas", Name.spades,
		"spades", Name.spades,
		"treboles", Name.clovers,
		"clovers", Name.clovers,
		"corazones", Name.hearts,
		"hearts", Name.hearts,
		"diamantes", Name.diamonds,
		"diamonds", Name.diamonds
	);
	
	private static final Map<Name, String> strDecode = Map.of(
		Name.spades, "Picas",
		Name.clovers, "Treboles",
		Name.hearts, "Corazones",
		Name.diamonds, "Diamantes"
	);
	
	private static final Map<Name, String> picDecode = Map.of(
		Name.spades, "Picas",
		Name.clovers, "Trebol",
		Name.hearts, "Corazon",
		Name.diamonds, "Diamante"
	);
}
