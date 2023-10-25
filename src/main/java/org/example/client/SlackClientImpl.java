package org.example.client;

import java.util.Map;

public class SlackClientImpl implements SlackClient {

    private static final String EMPTY_TOKEN = "";

    private final Map<String, String> passwordToToken = Map.of(
            "123", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY3Rpb25zIjpbIklOVklURSIsIlNFTkRfTUVTU0FHRSJdfQ.wtH8FUikvjiLM7y2qcMM69h5jYyZCfsPGgIOVG6aoig",
            "1234", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY3Rpb25zIjpbIklOVklURSJdfQ.ubytfMAo_xBfPtPisod_psf8txD43za386kEuZNiBHo",
            "12345", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY3Rpb25zIjpbIkNSRUFURSIsIklOVklURSIsIlNFTkRfTUVTU0FHRSIsIkFSQ0hJVkUiXX0.To7zVIl9kANr_codFZUxPX0lqILqFyNiJH-s6ewPirY",
            "123456", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY3Rpb25zIjpbXX0.EUXSOvolNCmDHL-xcNgWeLmwAfFqO6r5FDS7P7_YYoI",
            "1234567", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY3Rpb25zMTIzIjpbXX0.qBqyH5Fg7bj_VPlqQ7qieBOtAPqZYuT598jBnfmilRY"); // This token is invalid for testing purposes


    @Override
    public String retrieveToken(String password) {
        return passwordToToken.getOrDefault(password, EMPTY_TOKEN);
    }
}
