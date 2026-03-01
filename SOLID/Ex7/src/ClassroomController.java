public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        InputConnectable pj = reg.getFirstOfType(InputConnectable.class);
        pj.powerOn();
        pj.connectInput("HDMI-1");

        BrightnessControllable lights = reg.getFirstOfType(BrightnessControllable.class);
        lights.setBrightness(60);

        TemperatureControllable ac = reg.getFirstOfType(TemperatureControllable.class);
        ac.setTemperatureC(24);

        AttendanceTrackable scan = reg.getFirstOfType(AttendanceTrackable.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getFirstOfType(InputConnectable.class).powerOff();
        reg.getFirstOfType(BrightnessControllable.class).powerOff();
        reg.getFirstOfType(TemperatureControllable.class).powerOff();
    }
}
