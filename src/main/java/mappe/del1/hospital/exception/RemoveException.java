package mappe.del1.hospital.exception;

/**
 * Captures that a given object doesn't exist in the register
 */
public class RemoveException extends Exception
{
    private static final long serialVersionUID = 1L;

    public RemoveException(String message)
    {
        super(message);
    }
}
