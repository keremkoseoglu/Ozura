package search;

import java.util.ArrayList;
import java.util.Collections;

import model.Contract;

public class Comparer {

	private SelectionScreen ss;
	private CompareResult ret;
	private int activeSelectOptionCount;
	
	public Comparer(SelectionScreen SS) {
		ss = SS;
	}

	
	public CompareResult compare(Contract C) {
		
		ret = new CompareResult();
		ret.contract = C;
		activeSelectOptionCount = 0;
		
		compareSingle(ss.height, C.height, "Yükseklik");
		compareSingle(ss.length, C.length, "Uzunluk");
		compareSingle(ss.width, C.width, "Genişlik");
		
		compareSingle(ss.client, C.client, "Müşteri");
		compareSingle(ss.description, C.description, "Açıklama");
		compareSingle(ss.id, C.id, "ID");
		compareSingle(ss.version, C.version, "Versiyon");
		
		compareSingle(ss.active, C.active, "Etkinlik");
		compareSingle(ss.cool, C.cool, "Soğutma");
		compareSingle(ss.economy, C.economy, "Tasarruf");
		compareSingle(ss.regain, C.regain, "Yeniden kazanım");
		compareSingle(ss.warm, C.warm, "Isıtma");
		
		compareSingle(ss.date, C.date, "Tarih");
		
		compareSingle(ss.space, C.space, "Mekan");
		
		if (activeSelectOptionCount != 0) ret.points = (ret.points * 100) / activeSelectOptionCount;
		
		return ret;	
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<CompareResult> CompareResults(ArrayList<Contract> Contracts) {
		ArrayList<CompareResult> retl = new ArrayList<CompareResult>();
		for (int n = 0; n < Contracts.size(); n++) {
			CompareResult cr = compare(Contracts.get(n));
			if (cr.points > 0) retl.add(cr);
		}
		
		Collections.sort(retl, Collections.reverseOrder());
		
		return retl;
	}
	
	private void compareSingle(SelectOption SO, Object Value, String FieldName) {
		
		if (SO == null) return;
		activeSelectOptionCount++;
		
		if (!SO.matches(Value)) return;
		
		CompareResultLine crl = new CompareResultLine();
		crl.fieldName = FieldName;
		crl.fieldValue = String.valueOf(Value);
		ret.fields.add(crl);
		ret.points++;
		
	}
	
}
