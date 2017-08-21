package jp.co.unirita.nippouChan.application;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.nippou.NippouRepository;
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
        user.setUserId(nippou.getUser().getUserId());
        nippou.setNippouEdit(new Timestamp(System.currentTimeMillis()));
        nippouRepository.save(nippou);

    }

    /**
     * (サンプル実装)
     * userIdをキーにしてDBから日報のリストを取得して返す
     * @param nippouId
     * @return
     */
    public List<Nippou> getListByNippouId(int nippouId) {
        return nippouRepository.findByNippouId(nippouId);
    }

    /**
     * (サンプル実装)
     * nippouIdをキーにしてDBから日報を取得して返す
     * @param nippouId
     * @return
     */
    /*
    public Nippou getOne(int nippouId) {
        return nippouRepository.findOne(nippouId);
    }
    */
}
