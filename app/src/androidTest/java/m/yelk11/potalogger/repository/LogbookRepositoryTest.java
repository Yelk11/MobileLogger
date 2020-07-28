package m.yelk11.potalogger.repository;

import android.app.Application;
import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.dbc.entity.Logbook;


class LogbookRepositoryTest {

    @Test
    void insert() {
        Application application = Mockito.mock(Application.class);
        LogbookRepository logbookRepository = new LogbookRepository(application);

        Logbook logbook = new Logbook();
        logbookRepository.insert(logbook);
        Assert.assertEquals(logbookRepository.getAllLogbooks().getValue().get(0), logbook);
    }
}