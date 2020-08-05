package m.yelk11.potalogger.adif;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.marsik.ham.adif.AdiWriter;
import org.marsik.ham.adif.Adif3Record;
import org.marsik.ham.adif.enums.Mode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.repository.EntryRepository;

import static android.content.Context.MODE_PRIVATE;
import static java.security.AccessController.getContext;

public class WriteADIF {
    private EntryRepository entryRepository;
    private Application application;

    public WriteADIF(Application application){
        entryRepository = new EntryRepository(application);
        this.application = application;
    }

    public String write(Book book, List<Entry> entryList){
        AdiWriter writer = new AdiWriter();

        writer.append(book.getTitle(), true);




        for  (int i = 0; entryList.size() > i; i++) {
            writer.append(convertToRecord(entryList.get(i)));
        }
        return writer.toString(); // -> to some output
    }




    public Adif3Record convertToRecord(Entry entry){
        Adif3Record record = new Adif3Record();
        //record.setTimeOn();
        LocalDate localDate = LocalDate.parse(entry.getmDate());
        record.setQsoDate(localDate);
        record.setRstRcvd(entry.getmPowerReportRx());
        record.setRstSent(entry.getmPowerReportTx());
        record.setMode(Mode.valueOf(entry.getmMode()));
        record.setMyGridSquare(entry.getmGridsquareTx());
        record.setGridsquare(entry.getmGridsquareRx());
        record.setFreq(Double.valueOf(entry.getmFrequency()));
        record.setComment(entry.getmCommentRx());
        //record.setOperator();
        record.setCall(entry.getmCallsignTx());
        record.setContactedOp(entry.getmCallsignRx());

        return record;
    }


}
