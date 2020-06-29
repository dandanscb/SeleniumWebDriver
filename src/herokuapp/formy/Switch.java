package herokuapp.formy;

public class Switch {

    public static void main(String[] args) throws InterruptedException {
        Autocomplete autocomplete;
        Buttons buttons;
        Checkboxes checkbox;
        CompleteWebForm completewebform;
        Datepicker datepicker;
        DragAndDrop draganddrop;
        Dropdown dropdown;
        FileUpload fileupload;
        KeyboardAndMouseInput keyandmousepress;
        Modal modal;
        PageScroll pagescroll;
        RadioButtons radiobuttons;
        SwitchWindow switchwindow;
        try {
            autocomplete = new Autocomplete();
            autocomplete.main();
            Thread.sleep(500);
            buttons = new Buttons();
            buttons.main();
            Thread.sleep(500);
            checkbox = new Checkboxes();
            checkbox.main();
            Thread.sleep(500);
            datepicker = new Datepicker();
            datepicker.main();
            Thread.sleep(500);
            draganddrop = new DragAndDrop();
            draganddrop.main();
            dropdown = new Dropdown();
            dropdown.main();
            Thread.sleep(500);
            fileupload = new FileUpload();
            fileupload.main();
            Thread.sleep(500);
            keyandmousepress = new KeyboardAndMouseInput();
            keyandmousepress.main();
            Thread.sleep(500);
            modal = new Modal();
            modal.main();
            Thread.sleep(500);
            pagescroll = new PageScroll();
            pagescroll.main();
            Thread.sleep(500);
            radiobuttons = new RadioButtons();
            radiobuttons.main();
            Thread.sleep(500);
            switchwindow = new SwitchWindow();
            switchwindow.main();
            completewebform = new CompleteWebForm();
            completewebform.main();
            Thread.sleep(500);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }

    }

}
