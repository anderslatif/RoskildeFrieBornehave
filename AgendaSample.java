import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import jfxtras.samples.JFXtrasSampleBase;
import jfxtras.scene.control.LocalDateTimeTextField;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.Appointment;
import jfxtras.scene.control.agenda.Agenda.LocalDateTimeRange;
import jfxtras.scene.control.agenda.AgendaSkinSwitcher;
import jfxtras.scene.layout.GridPane;

public class AgendaSample extends JFXtrasSampleBase{
    public AgendaSample() {
        agenda = new Agenda();

        // setup appointment groups
        final Map<String, Agenda.AppointmentGroup> lAppointmentGroupMap = new TreeMap<String, Agenda.AppointmentGroup>();
        for (Agenda.AppointmentGroup lAppointmentGroup : agenda.appointmentGroups()) {
            lAppointmentGroupMap.put(lAppointmentGroup.getDescription(), lAppointmentGroup);
        }

        // accept new appointments
        agenda.newAppointmentCallbackProperty().set(new Callback<LocalDateTimeRange, Appointment>()        {
            @Override
            public Appointment call(LocalDateTimeRange dateTimeRange)
            {
                return new Agenda.AppointmentImplLocal()
                        .withStartLocalDateTime( dateTimeRange.getStartLocalDateTime() )
                        .withEndLocalDateTime( dateTimeRange.getEndLocalDateTime() )
                        .withSummary("new")
                        .withDescription("new")
                        .withAppointmentGroup(lAppointmentGroupMap.get("group01"));
            }
        });

        // initial set
        LocalDate lTodayLocalDate = LocalDate.now();
        LocalDate lTomorrowLocalDate = LocalDate.now().plusDays(1);
        int idx = 0;
        LocalDateTime lMultipleDaySpannerStartDateTime = lTodayLocalDate.atStartOfDay().plusHours(5);
        lMultipleDaySpannerStartDateTime = lMultipleDaySpannerStartDateTime.minusDays(lMultipleDaySpannerStartDateTime.getDayOfWeek().getValue() > 3 && lMultipleDaySpannerStartDateTime.getDayOfWeek().getValue() < 7 ? 3 : -1);
        LocalDateTime lMultipleDaySpannerEndDateTime = lMultipleDaySpannerStartDateTime.plusDays(2);

        Appointment[] lTestAppointments = new Appointment[]{
                     new Agenda.AppointmentImpl()
                .withStartTime(new GregorianCalendar(lTodayLocalDate.getYear(), lTodayLocalDate.getMonthValue() - 1, lTodayLocalDate.getDayOfMonth(), 7, 00))
                .withEndTime(new GregorianCalendar(lTodayLocalDate.getYear(), lTodayLocalDate.getMonthValue() - 1, lTodayLocalDate.getDayOfMonth(), 17, 30))
                .withSummary("Testmann von Duke")
                .withDescription("Calendar based")
                .withAppointmentGroup(lAppointmentGroupMap.get("group08")),
                new Agenda.AppointmentImpl()
                        .withStartTime(new GregorianCalendar(lTodayLocalDate.getYear(), lTodayLocalDate.getMonthValue() - 1, lTodayLocalDate.getDayOfMonth() - 2, 7, 00))
                        .withEndTime(new GregorianCalendar(lTodayLocalDate.getYear(), lTodayLocalDate.getMonthValue() - 1, lTodayLocalDate.getDayOfMonth() - 2, 15, 30))
                        .withSummary("Simone")
                        .withDescription("Calendar based")
                        .withAppointmentGroup(lAppointmentGroupMap.get("group02"))
                , new Agenda.AppointmentImpl()
                        .withStartTime(new GregorianCalendar(lTodayLocalDate.getYear(), lTodayLocalDate.getMonthValue() - 1, lTodayLocalDate.getDayOfMonth() - 2, 7, 00))
                        .withEndTime(new GregorianCalendar(lTodayLocalDate.getYear(), lTodayLocalDate.getMonthValue() - 1, lTodayLocalDate.getDayOfMonth() - 2, 15, 30))
                        .withSummary("Sandra Larsen")
                        .withDescription("Calendar based")
                        .withAppointmentGroup(lAppointmentGroupMap.get("group02"))
                // ZonedDateTime: there is no additional value in using ZonedDateTime everywhere, so we just have one test appointment
                /*,     new Agenda.AppointmentImplTemporal()
                .withStartTemporal(ZonedDateTime.of(lTodayLocalDate, LocalTime.of(2, 00), ZoneId.systemDefault()) )
                .withEndTemporal(ZonedDateTime.of(lTodayLocalDate, LocalTime.of(3, 30), ZoneId.systemDefault()) )
                .withSummary("Zoned")
                .withDescription("Zoned based")
                .withAppointmentGroup(lAppointmentGroupMap.get("group08"))*/
                // -----
                // too short for actual rendering
                ,     new Agenda.AppointmentImplLocal()
                .withStartLocalDateTime(LocalDateTime.of(lTodayLocalDate, LocalTime.of(20, 30)))
                .withEndLocalDateTime(LocalDateTime.of(lTodayLocalDate, LocalTime.of(20, 31)))
                .withSummary("Sandra Larsen")
                .withDescription("Too short")
                .withAppointmentGroup(lAppointmentGroupMap.get("group07"))
                // -----
                // tasks
                // -----
                // regular spanning
        };
        agenda.appointments().addAll(lTestAppointments);

        // action
        agenda.setActionCallback( (appointment) -> {
            showPopup(agenda, "Action on " + appointment);
            return null;
        });
    }
    final Agenda agenda;

    @Override
    public String getSampleName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getSampleDescription() {
        return "Agenda is a Google calendar alike control. \n"
                + "It requires a list of appointments to be shown. An appointment is just an interface, so you can provide your own implementation (usually a domain entity), but there also is a default implementation avaiable for easy experimenting. \n"
                + "Similar to calendars in Google calendar, Agenda has the concept of AppointmentGroups. A group is used to style all the appointments in the same group identically, for example by setting the color in CSS. "
                ;
    }

    @Override
    public Node getPanel(Stage stage) {
        return agenda;
    }

    @Override
    public Node getControlPanel() {
        // the result
        GridPane lGridPane = new GridPane();
        lGridPane.setVgap(2.0);
        lGridPane.setHgap(2.0);

        // setup the grid so all the labels will not grow, but the rest will
        ColumnConstraints lColumnConstraintsAlwaysGrow = new ColumnConstraints();
        lColumnConstraintsAlwaysGrow.setHgrow(Priority.ALWAYS);
        ColumnConstraints lColumnConstraintsNeverGrow = new ColumnConstraints();
        lColumnConstraintsNeverGrow.setHgrow(Priority.NEVER);
        lGridPane.getColumnConstraints().addAll(lColumnConstraintsNeverGrow, lColumnConstraintsAlwaysGrow);
        int lRowIdx = 0;

        // skin
        {
            lGridPane.add(new Label("Skin"), new GridPane.C().row(lRowIdx).col(0).halignment(HPos.RIGHT));
            AgendaSkinSwitcher lAgendaSkinSwitcher = new AgendaSkinSwitcher(agenda);
            lGridPane.add(lAgendaSkinSwitcher, new GridPane.C().row(lRowIdx).col(1));
        }
        lRowIdx++;

        // displayed calendar
        {
            lGridPane.add(new Label("Display"), new GridPane.C().row(lRowIdx).col(0).halignment(HPos.RIGHT));
            LocalDateTimeTextField lLocalDateTimeTextField = new LocalDateTimeTextField();
            lGridPane.add(lLocalDateTimeTextField, new GridPane.C().row(lRowIdx).col(1));
            lLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(agenda.displayedLocalDateTime());
        }
        lRowIdx++;

        // AllowDragging
        {
            lGridPane.add(new Label("Allow dragging"), new GridPane.C().row(lRowIdx).col(0).halignment(HPos.RIGHT));
            CheckBox lCheckBox = new CheckBox();
            lCheckBox.setSelected(true);
            lGridPane.add(lCheckBox, new GridPane.C().row(lRowIdx).col(1));
            agenda.allowDraggingProperty().bind(lCheckBox.selectedProperty());
        }
        lRowIdx++;

        // AllowResize
        {
            lGridPane.add(new Label("Allow resize"), new GridPane.C().row(lRowIdx).col(0).halignment(HPos.RIGHT));
            CheckBox lCheckBox = new CheckBox();
            lCheckBox.setSelected(true);
            lGridPane.add(lCheckBox, new GridPane.C().row(lRowIdx).col(1));
            agenda.allowResizeProperty().bind(lCheckBox.selectedProperty());
        }
        lRowIdx++;

        // Locale
        {
            lGridPane.add(new Label("Locale"), new GridPane.C().row(lRowIdx).col(0).halignment(HPos.RIGHT));
            ObservableList<Locale> lLocales = FXCollections.observableArrayList(Locale.getAvailableLocales());
            FXCollections.sort(lLocales,  (o1, o2) -> { return o1.toString().compareTo(o2.toString()); } );
            ComboBox<Locale> lComboBox = new ComboBox<>( lLocales );
            lComboBox.converterProperty().set(new StringConverter<Locale>() {
                @Override
                public String toString(Locale locale) {
                    return locale == null ? "-"  : locale.toString();
                }

                @Override
                public Locale fromString(String s) {
                    if ("-".equals(s)) return null;
                    return new Locale(s);
                }
            });
            lComboBox.setEditable(true);
            lGridPane.add(lComboBox, new GridPane.C().row(lRowIdx).col(1));
            lComboBox.valueProperty().bindBidirectional(agenda.localeProperty());
        }
        lRowIdx++;

        // print
        {
            lGridPane.add(new Label("Print"), new GridPane.C().row(lRowIdx).col(0).halignment(HPos.RIGHT));
            Button lButton = new Button("Print to default printer");
            lGridPane.add(lButton, new GridPane.C().row(lRowIdx).col(1));
            lButton.setOnAction( (event) -> {
                print();
            });
        }
        lRowIdx++;

        // done
        return lGridPane;
    }

/*    /** Scales the node based on the standard letter, portrait paper to be printed.
     * @param void The scene node to be printed.
     */
    public void print() {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            agenda.print(job);
            job.endJob();
        }
    }

    @Override
    public String getJavaDocURL() {
        return "http://jfxtras.org/doc/8.0/jfxtras-agenda/" + Agenda.class.getName().replace(".", "/") + ".html";
    }

    public static void main(String[] args) {
        launch(args);
    }


    /**
     * get the calendar for the first day of the week
     */
    static private Calendar getFirstDayOfWeekCalendar(Locale locale, Calendar c)
    {
        // result
        int lFirstDayOfWeek = Calendar.getInstance(locale).getFirstDayOfWeek();
        int lCurrentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int lDelta = 0;
        if (lFirstDayOfWeek <= lCurrentDayOfWeek)
        {
            lDelta = -lCurrentDayOfWeek + lFirstDayOfWeek;
        }
        else
        {
            lDelta = -lCurrentDayOfWeek - (7-lFirstDayOfWeek);
        }
        c = ((Calendar)c.clone());
        c.add(Calendar.DATE, lDelta);
        return c;
    }

}