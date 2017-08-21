import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.unirita.nippouChan.Application;
import jp.co.unirita.nippouChan.application.NippouService;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.nippou.NippouRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class NippouServiceTest {
    @Autowired
    NippouService nippouService;

    @MockBean
    NippouRepository nippouRepository;

    /**
     * NippouService::create(..)のテスト
     * メソッドに渡したオブジェクトに現在日時とユーザがセットされ、DBへの保存が呼び出されていることを確認する
     */
    @Test
    public void 日報の作成_正常系() {
        Nippou nippou = new Nippou();
        nippou.setNippouTitle("タイトル");
        nippou.setNippouContents("ほげほげ");
        nippouService.create(nippou);

        assertThat(nippou.getNippouRegister(), is(notNullValue()));
        assertThat(nippou.getUser().getUserId(), is("test_user"));
        Mockito.verify(nippouRepository).save(nippou);
    }
}
