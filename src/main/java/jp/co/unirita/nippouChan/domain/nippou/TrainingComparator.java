package jp.co.unirita.nippouChan.domain.nippou;

import java.util.Comparator;

public class TrainingComparator  implements Comparator<Nippou> {

	@Override
	public int compare(Nippou n1, Nippou n2) {
		return n1.getNippouTraining().after(n2.getNippouTraining()) ? -1 : 1;
	}

}
