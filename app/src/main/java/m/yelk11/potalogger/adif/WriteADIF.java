package m.yelk11.potalogger.adif;

import android.app.Application;


import org.marsik.ham.adif.AdiWriter;
import org.marsik.ham.adif.Adif3Record;
import org.marsik.ham.adif.AdifHeader;

import java.util.List;

import m.yelk11.potalogger.BuildConfig;

import m.yelk11.potalogger.dbc.converter.EntryConverter;
import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;


public class WriteADIF {

    Application application;
    EntryConverter entryConverter;

    public WriteADIF(Application application){
        this.application = application;
        entryConverter = new EntryConverter();
    }

    public String write(Book book, List<Entry> entryList){


        AdifHeader header = new AdifHeader();

        AdiWriter writer = new AdiWriter();
        writer.append(header);
        writer.append(book.getTitle(), true);

        for  (int i = 0; entryList.size() > i; i++) {
            writer.append(convertToRecord(entryList.get(i)));
        }
        AdifFormatter formatter = new AdifFormatter(writer.toString());
        return formatter.getFormattedString();
    }




    public Adif3Record convertToRecord(Entry entry){
        Adif3Record record = new Adif3Record();
        //record.setTimeOn();
        //LocalDate localDate = LocalDate.parse(entry.getmDate());
        //record.setQsoDate(localDate);
        record.setRstRcvd(entry.getmPowerReportRx());
        record.setRstSent(entry.getmPowerReportTx());
        //record.setMode(Mode.valueOf(entry.getmMode()));
        record.setMyGridSquare(entry.getmGridsquareTx());
        record.setGridsquare(entry.getmGridsquareRx());
        //record.setFreq(Double.valueOf(entry.getmFrequency()));
        record.setComment(entry.getmCommentRx());
        //record.setOperator();
        record.setCall(entry.getmCallsignTx());
        record.setContactedOp(entry.getmCallsignRx());
        //record.setBand(entry.getmBand());
        return record;
    }


}
