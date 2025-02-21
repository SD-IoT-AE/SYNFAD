// MLDM Algorithm Implementation (Java)

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MLDM {

    private final long monWinDur;
    private final long mitigationInterval;
    private final Queue<Map<String, Object>> alertQueue = new LinkedList<>();
    private final Map<String, Object> mitigationRules = new ConcurrentHashMap<>();
    private final Map<String, Object> currentNetworkState = new ConcurrentHashMap<>();

    public MLDM(long monWinDur, long mitigationInterval) {
        this.monWinDur = monWinDur;
        this.mitigationInterval = mitigationInterval;
    }

    public void applyMitigationRules(String switchId, Map<String, Object> rules) {
        System.out.println("Applying rules " + rules + " to switch " + switchId);
    }

    public void distributeMitigationRules(String targetSegment, Map<String, Object> rules) {
        System.out.println("Distributing rules " + rules + " to segment " + targetSegment);
    }

    public String determineMitigationLevel(Map<String, Object> alert) {
        int atkSev = (int) alert.get("atkSev");
        if (atkSev == 3) {
            return "Global";
        } else if (atkSev == 2) {
            return "Regional";
        } else {
            return "Local";
        }
    }

    public Map<String, Object> generateMitigationRules(Map<String, Object> alert, String mitigationLevel, Map<String, Object> networkState) {
        Map<String, Object> rules = new HashMap<>();
        rules.put("rule", "Mitigation rule for " + mitigationLevel);
        return rules;
    }

    public String getTargetPC(Map<String, Object> alert) {
        // Implement logic to get target PC based on alert
        return "PC1"; 
    }

    public String getTargetRegion(Map<String, Object> alert) {
        // Implement logic to get target region based on alert
        return "Region1"; 
    }

    public boolean hasAlert() {
        return !alertQueue.isEmpty();
    }

    public Map<String, Object> getAlert() {
        return alertQueue.poll();
    }

    public Map<String, Object> getCurrentNetworkState() {
        // Implement logic to get current network state
        Map<String, Object> state = new HashMap<>();
        state.put("state", "Network state");
        return state;
    }

    public Map<String, Object> adjustMitigationRules(Map<String, Object> rules, Map<String, Object> networkState) {
        Map<String, Object> adjustedRules = new HashMap<>();
        adjustedRules.put("adjusted_rule", "Adjusted rule");
        return adjustedRules;
    }

    public void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void mitigationProcess() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            if (hasAlert()) {
                Map<String, Object> alert = getAlert();
                String mitigationLevel = determineMitigationLevel(alert);
                Map<String, Object> rules = generateMitigationRules(alert, mitigationLevel, currentNetworkState);

                if (mitigationLevel.equals("Local")) {
                    String targetPC = getTargetPC(alert);
                    String[] switches = {"Switch_1", "Switch_2", "Switch_3"}; // Placeholder switches
                    for (String switchId : switches) {
                        applyMitigationRules(switchId, rules);
                    }
                } else if (mitigationLevel.equals("Regional")) {
                    String targetRegion = getTargetRegion(alert);
                    distributeMitigationRules(targetRegion, rules);
                } else if (mitigationLevel.equals("Global")) {
                    distributeMitigationRules("Net", rules);
                }
            }

            if (System.currentTimeMillis() % monWinDur == 0) {
                currentNetworkState.putAll(getCurrentNetworkState());
                if (!mitigationRules.isEmpty()) {
                    mitigationRules.putAll(adjustMitigationRules(mitigationRules, currentNetworkState));
                    distributeMitigationRules("Net", mitigationRules);
                }
                sleep(mitigationInterval);
            }
        }, 0, 100, TimeUnit.MILLISECONDS); //check every 100ms
    }

    public void start() {
        mitigationProcess();
    }

    public static void main(String[] args) {
        MLDM mldm = new MLDM(5000, 1000); // Example: 5s window, 1s interval
        mldm.start();

        // Placeholder for alert injection (Replace with your controller integration)
        ScheduledExecutorService alertScheduler = Executors.newScheduledThreadPool(1);
        alertScheduler.scheduleAtFixedRate(() -> {
            Map<String, Object> alert = new HashMap<>();
            alert.put("atkSev", new Random().nextInt(3) + 1); // Random severity 1, 2, or 3
            mldm.alertQueue.add(alert);
        }, 0, 2, TimeUnit.SECONDS); // inject an alert every 2 seconds.

        // Keep the main thread alive (or use a proper controller integration)
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
