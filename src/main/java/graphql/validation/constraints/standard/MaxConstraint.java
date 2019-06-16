package graphql.validation.constraints.standard;

public class MaxConstraint extends AbstractMinMaxConstraint {

    public MaxConstraint() {
        super("Max");
    }

    @Override
    public String getDirectiveDeclarationSDL() {
        return String.format("directive @Max(value : Int! = %d, message : String = \"%s\") " +
                        "on ARGUMENT_DEFINITION | INPUT_FIELD_DEFINITION",
                Integer.MAX_VALUE, getMessageTemplate());
    }

    @Override
    public String getDescription() {
        return "The element must be a number whose value must be less than or equal to the specified maximum.";
    }

    @Override
    public String getExample() {
        return "driver( horsePower : Float @Max(value : 1000) : DriverDetails";
    }


    @Override
    protected boolean isOK(int comparisonResult) {
        return comparisonResult <= 0;
    }
}
