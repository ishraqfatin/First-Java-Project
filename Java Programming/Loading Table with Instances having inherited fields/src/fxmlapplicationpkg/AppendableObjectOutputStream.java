
package fxmlapplicationpkg;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() {}
} 
