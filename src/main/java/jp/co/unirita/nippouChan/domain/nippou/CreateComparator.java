package jp.co.unirita.nippouChan.domain.nippou;

import java.util.Comparator;

public class CreateComparator implements Comparator<Nippou> {

	@Override
	public int compare(Nippou n1, Nippou n2) {
		return n1.getNippouRegister().after(n2.getNippouRegister()) ? -1 : 1;
	}

}
