package m.yelk11.potalogger.models;

import m.yelk11.potalogger.ui.fragments.LogEntryFragment;

public class LogEntryType extends LogEntryFragment {

    private String name;

    private enum ADIF_types {
        ADDRESS,
        ADDRESS_INTL,
        AGE,
        A_INDEX,
        ANT_AZ,
        ANT_EL,
        ANT_PATH,
        ARRL_SECT,
        AWARD_SUBMITTED,
        AWARD_GRANTED,
        BAND,
        BAND_RX,
        CALL,
        CHECK,
        CLASS,
        CLUBLOG_QSO_UPLOAD_DATE,
        CLUBLOG_QSO_UPLOAD_STATUS,
        CNTY,
        COMMENT,
        COMMENT_INTL,
        CONT,
        CONTACTED_OP,
        CONTEST_ID,
        COUNTRY,
        COUNTRY_INTL,
        CQZ,
        CREDIT_SUBMITTED,
        CREDIT_GRANTED,
        DARC_DOK,
        EQSL_QSLSDATE,
        EQSL_QSL_RCVD,
        EQSL_QSL_SENT,
        FISTS,
        FISTS_CC,
        FORCE_INIT,
        FREQ,
        FREQ_RX,
        GRIDSQUARE,
        GUEST_OP,
        HRDLOG_QSO_UPLOAD_DATE,
        HRDLOG_QSO_UPLOAD_STATUS,
        IOTA,
        IOTA_ISLAND_ID,
        ITUZ,
        K_INDEX,
        LAT,
        LON,
        LOTW_QSLRDATE,
        LOTW_QSLSDATE,
        LOTW_QSL_RCVD,
        LOTW_QSL_SENT,
        MAX_BURSTS,
        MODE,
        MS_SHOWER,
        MY_ANTENNA,
        MY_ANTENNA_INTL,
        MY_CITY,
        MY_CITY_INTL,
        MY_CNTY,
        MY_COUNTRY,
        MY_COUNTRY_INTL,
        MY_CQ_ZONE,
        MY_DXCC,
        MY_FISTS,
        MY_GRIDSQUARE,
        MY_IOTA,
        MY_IOTA_ISLAND_ID,
        MY_ITU_ZONE,
        MY_LAT,
        MY_LON,
        MY_NAME,
        MY_NAME_INTL,
        MY_POSTAL_CODE,
        MY_POSTAL_CODE_INTL,
        MY_RIG,
        MY_RIG_INTL,
        MY_SIG,
        MY_SIG_INTL,
        MY_SIG_INFO,
        MY_SIG_INFO_INTL,
        MY_SOTA_REF,
        MY_STATE,
        MY_STREET,
        MY_STREET_INTL,
        MY_USACA_COUNTIES,
        MY_VUCC_GRIDS,
        NAME,
        NAME_INTL,
        NOTES,
        NOTES_INTL,
        NR_BURSTS,
        NR_PINGS,
        OPERATOR,
        OWNER_CALLSIGN,
        PFX,
        PRECEDENCE,
        PROP_MODE,
        PUBLIC_KEY,
        QRZCOM_QSO_UPLOAD_DATE,
        QRZCOM_QSO_UPLOAD_STATUS,
        QSLMSG,
        QSLMSG_INTL,
        QSLRDATE,
        QSLSDATE,
        QSL_RCVD,
        QSL_RCVD_VIA,
        QSL_SENT,
        QSL_SENT_VIA,
        QSL_VIA,
        QSO_COMPLETE,
        QSO_DATE,
        QSO_DATE_OFF,
        QSO_RANDOM,
        QTH,
        QTH_INTL,
        REGION,
        RIG,
        RIG_INTL,
        RST_RCVD,
        RST_SENT,
        RX_PWR,
        SAT_MODE,
        SAT_NAME,
        SFI,
        SIG,
        SIG_INTL,
        SIG_INFO,
        SIG_INFO_INTL,
        SILENT_KEY,
        SKCC,
        SOTA_REF,
        SRX,
        SRX_STRING,
        STATE,
        STATION_CALLSIGN,
        STX,
        STX_STRING,
        SUBMODE,
        SWL,
        TEN_TEN,
        TIME_OFF,
        TIME_ON,
        TX_PWR,
        UKSMG,
        USACA_COUNTIES,
        VE_PROV,
        VUCC_GRIDS,
        WEB,
    }

    public LogEntryType(String name) {
        this.name = name;
    }



    public void createView(ADIF_types type) {
        switch (type) {
            case ADDRESS:

                break;
            case ADDRESS_INTL:
                break;
            case AGE:
                break;
            case A_INDEX:
                break;
            case ANT_AZ:
                break;
            case ANT_EL:
                break;
            case ANT_PATH:
                break;
            case ARRL_SECT:
                break;
            case AWARD_SUBMITTED:
                break;
            case AWARD_GRANTED:
                break;
            case BAND:
                break;
            case BAND_RX:
                break;
            case CALL:
                break;
            case CHECK:
                break;
            case CLASS:
                break;
            case CLUBLOG_QSO_UPLOAD_DATE:
                break;
            case CLUBLOG_QSO_UPLOAD_STATUS:
                break;
            case CNTY:
                break;
            case COMMENT:
                break;
            case COMMENT_INTL:
                break;
            case CONT:
                break;
            case CONTACTED_OP:
                break;
            case CONTEST_ID:
                break;
            case COUNTRY:
                break;
            case COUNTRY_INTL:
                break;
            case CQZ:
                break;
            case CREDIT_SUBMITTED:
                break;
            case CREDIT_GRANTED:
                break;
            case DARC_DOK:
                break;
            case EQSL_QSLSDATE:
                break;
            case EQSL_QSL_RCVD:
                break;
            case EQSL_QSL_SENT:
                break;
            case FISTS:
                break;
            case FISTS_CC:
                break;
            case FORCE_INIT:
                break;
            case FREQ:
                break;
            case FREQ_RX:
                break;
            case GRIDSQUARE:
                break;
            case GUEST_OP:
                break;
            case HRDLOG_QSO_UPLOAD_DATE:
                break;
            case HRDLOG_QSO_UPLOAD_STATUS:
                break;
            case IOTA:
                break;
            case IOTA_ISLAND_ID:
                break;
            case ITUZ:
                break;
            case K_INDEX:
                break;
            case LAT:
                break;
            case LON:
                break;
            case LOTW_QSLRDATE:
                break;
            case LOTW_QSLSDATE:
                break;
            case LOTW_QSL_RCVD:
                break;
            case LOTW_QSL_SENT:
                break;
            case MAX_BURSTS:
                break;
            case MODE:
                break;
            case MS_SHOWER:
                break;
            case MY_ANTENNA:
                break;
            case MY_ANTENNA_INTL:
                break;
            case MY_CITY:
                break;
            case MY_CITY_INTL:
                break;
            case MY_CNTY:
                break;
            case MY_COUNTRY:
                break;
            case MY_COUNTRY_INTL:
                break;
            case MY_CQ_ZONE:
                break;
            case MY_DXCC:
                break;
            case MY_FISTS:
                break;
            case MY_GRIDSQUARE:
                break;
            case MY_IOTA:
                break;
            case MY_IOTA_ISLAND_ID:
                break;
            case MY_ITU_ZONE:
                break;
            case MY_LAT:
                break;
            case MY_LON:
                break;
            case MY_NAME:
                break;
            case MY_NAME_INTL:
                break;
            case MY_POSTAL_CODE:
                break;
            case MY_POSTAL_CODE_INTL:
                break;
            case MY_RIG:
                break;
            case MY_RIG_INTL:
                break;
            case MY_SIG:
                break;
            case MY_SIG_INTL:
                break;
            case MY_SIG_INFO:
                break;
            case MY_SIG_INFO_INTL:
                break;
            case MY_SOTA_REF:
                break;
            case MY_STATE:
                break;
            case MY_STREET:
                break;
            case MY_STREET_INTL:
                break;
            case MY_USACA_COUNTIES:
                break;
            case MY_VUCC_GRIDS:
                break;
            case NAME:
                break;
            case NAME_INTL:
                break;
            case NOTES:
                break;
            case NOTES_INTL:
                break;
            case NR_BURSTS:
                break;
            case NR_PINGS:
                break;
            case OPERATOR:
                break;
            case OWNER_CALLSIGN:
                break;
            case PFX:
                break;
            case PRECEDENCE:
                break;
            case PROP_MODE:
                break;
            case PUBLIC_KEY:
                break;
            case QRZCOM_QSO_UPLOAD_DATE:
                break;
            case QRZCOM_QSO_UPLOAD_STATUS:
                break;
            case QSLMSG:
                break;
            case QSLMSG_INTL:
                break;
            case QSLRDATE:
                break;
            case QSLSDATE:
                break;
            case QSL_RCVD:
                break;
            case QSL_RCVD_VIA:
                break;
            case QSL_SENT:
                break;
            case QSL_SENT_VIA:
                break;
            case QSL_VIA:
                break;
            case QSO_COMPLETE:
                break;
            case QSO_DATE:
                break;
            case QSO_DATE_OFF:
                break;
            case QSO_RANDOM:
                break;
            case QTH:
                break;
            case QTH_INTL:
                break;
            case REGION:
                break;
            case RIG:
                break;
            case RIG_INTL:
                break;
            case RST_RCVD:
                break;
            case RST_SENT:
                break;
            case RX_PWR:
                break;
            case SAT_MODE:
                break;
            case SAT_NAME:
                break;
            case SFI:
                break;
            case SIG:
                break;
            case SIG_INTL:
                break;
            case SIG_INFO:
                break;
            case SIG_INFO_INTL:
                break;
            case SILENT_KEY:
                break;
            case SKCC:
                break;
            case SOTA_REF:
                break;
            case SRX:
                break;
            case SRX_STRING:
                break;
            case STATE:
                break;
            case STATION_CALLSIGN:
                break;
            case STX:
                break;
            case STX_STRING:
                break;
            case SUBMODE:
                break;
            case SWL:
                break;
            case TEN_TEN:
                break;
            case TIME_OFF:
                break;
            case TIME_ON:
                break;
            case TX_PWR:
                break;
            case UKSMG:
                break;
            case USACA_COUNTIES:
                break;
            case VE_PROV:
                break;
            case VUCC_GRIDS:
                break;
            case WEB:
                break;
        }
    }
}
