package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotBeatenException extends AbstractThrowableProblem {

    public NotBeatenException() {
        super(URI.create("worldrecords/not-beaten"),
                "Can not beat",
                Status.BAD_REQUEST);
    }
}
