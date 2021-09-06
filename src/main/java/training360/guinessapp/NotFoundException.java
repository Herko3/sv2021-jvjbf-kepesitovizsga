package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotFoundException extends AbstractThrowableProblem {

    public NotFoundException(String title, String message) {
        super(URI.create("not-found"),
                title,
                Status.NOT_FOUND,
                message);
    }
}
