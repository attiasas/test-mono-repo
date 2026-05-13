package dummy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * First-party test patterns: SQLi-style string concat (intentionally unsafe for SAST/Xray appsec tests).
 */
@RestController
public class InsecureQueryController {

    @GetMapping("/lookup")
    public String lookup(@RequestParam("id") String id) {
        // Vulnerable: unsanitized input concatenated into a pseudo-query
        String q = "SELECT * FROM users WHERE id = '" + id + "'";
        return "would run: " + q;
    }
}
