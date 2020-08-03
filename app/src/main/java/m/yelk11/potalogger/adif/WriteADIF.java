package m.yelk11.potalogger.adif;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.marsik.ham.adif.AdiWriter;
import org.marsik.ham.adif.Adif3Record;
import org.marsik.ham.adif.enums.Mode;

import java.time.LocalDate;
import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.repository.EntryRepository;

public class WriteADIF {
    EntryRepository entryRepository;

    public WriteADIF(Application application){
        entryRepository = new EntryRepository(application);
    }

    public void write(Book book){
        AdiWriter writer = new AdiWriter();
        List<Entry> bookEntries = getBookEntries(book);
        writer.append(book.getTitle(), true);




        for  (int i = 0; bookEntries.size() > i; i++) {
            writer.append(convertToRecord(bookEntries.get(i)));
        }
        writer.toString(); // -> to some output
    }

    public List<Entry> getBookEntries(Book book){

        return entryRepository.getBookEntries(book.getId()).getValue();
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
