package jp.co.unirita.nippouChan.application;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.unirita.nippouChan.domain.nippou.CreateComparator;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.nippou.NippouRepository;
import jp.co.unirita.nippouChan.domain.nippou.TrainingComparator;
import jp.co.unirita.nippouChan.domain.user.User;

@Service
public class NippouService {
    @Autowired
    NippouRepository nippouRepository;
    private static final AtomicInteger count = new AtomicInteger(0);

    /**
     * (サンプル実装)
     * 受け取ったReportオブジェクトのcreatedに現在日時、userに"test_user"を設定してDBに保存する。
     * @param nippou
     * @return
     */

    public void create(Nippou nippou) {
        User user = new User();
        user.setUserId("00001");
        nippou.setNippouRegister(new Timestamp(System.currentTimeMillis()));
        nippou.setNippouEdit(new Timestamp(System.currentTimeMillis()));
        nippou.setNippouId(count.incrementAndGet());
 //       nippou.setNippouId(nippou);
//        nippou.setUser(user); // TODO: 現在のログインユーザを取得して設定するようにしたい
//        nippou.setCreated(new Date());
        nippouRepository.save(nippou);
    }

    public void edit(Nippou nippou) {
        User user = new User();
        nippou.setNippouId(nippou.getNippouId());
        user.setUserId(nippou.getUser().getUserId());
        nippou.setNippouEdit(new Timestamp(System.currentTimeMillis()));
        nippouRepository.save(nippou);

    }

    /**
     * (サンプル実装)
     * userIdをキーにしてDBから日報のリストを取得して返す
     * @param nippouId
     * @return List<Nippou>
     */
    public List<Nippou> getListByNippouId(int nippouId) {
        return nippouRepository.findByNippouId(nippouId);
    }

    /**
     * (サンプル実装)
     * nippouIdをキーにしてDBから日報を取得して返す
     * @param nippouId
     * @return Nippou
     */

    public Nippou getOne(int nippouId) {
        return nippouRepository.findOne(nippouId);
    }


    public List<Nippou> getAll() {
		return nippouRepository.findAll();
	}



    /**
     * nippouIdをキーにしてDBから日報を取得し、作成日時の降順(最新)でソートして返す
     * @param nippouId
     * @return List<Nippou>
     */
    public List<Nippou> getListByNewest(int nippouId) {
    	List<Nippou> nippouList = nippouRepository.findByNippouId(nippouId);
    	Collections.sort(nippouList, new CreateComparator());
    	return nippouList;
    }

    /**
     * nippouIdをキーにしてDBから日報を取得し、研修日時の降順(最新)でソートして返す
     * @param nippouId
     * @return List<Nippou>
     */
    public List<Nippou> getListByTraining(int nippouId) {
    	List<Nippou> nippouList = nippouRepository.findByNippouId(nippouId);
    	Collections.sort(nippouList, new TrainingComparator());
    	return nippouList;
    }

}
