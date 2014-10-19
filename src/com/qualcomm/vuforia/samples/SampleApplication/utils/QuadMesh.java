package com.qualcomm.vuforia.samples.SampleApplication.utils;

import java.nio.Buffer;


public class QuadMesh extends MeshObject
{

	private Buffer mVertBuff;
	private Buffer mTexCoordBuff;
	private Buffer mNormBuff;
	private Buffer mIndBuff;

	private int indicesNumber = 0;
	private int verticesNumber = 0;


	public QuadMesh()
	{
		setVerts();
		setTexCoords();
		setNorms();
		setIndices();
	}


	private void setVerts()
	{

		double quadVertices[] =
			{
			    -0.5f, -0.5f, 0.0f, //bottom-left corner
			     0.5f, -0.5f, 0.0f, //bottom-right corner
			     0.5f, 0.5f, 0.0f, //top-right corner
			    -0.5f, 0.5f, 0.0f //top-left corner
			};
		mVertBuff = fillBuffer(quadVertices);
		verticesNumber = quadVertices.length / 3;
	}


	private void setTexCoords()
	{

		double quadTexcoords[] =
			{
			    0.0f, 0.0f, //tex-coords at bottom-left corner
			    1.0f, 0.0f, //tex-coords at bottom-right corner
			    1.0f, 1.0f, //tex-coords at top-right corner
			    0.0f, 1.0f  //tex-coords at top-left corner
			};


		mTexCoordBuff = fillBuffer(quadTexcoords);

	}


	private void setNorms()
	{

		double quadNormals[] =
			{
			    0.0f, 0.0f, 1.0f, //normal at bottom-left corner
			    0.0f, 0.0f, 1.0f, //normal at bottom-right corner
			    0.0f, 0.0f, 1.0f, //normal at top-right corner
			    0.0f, 0.0f, 1.0f  //normal at top-left corner
			};

		mNormBuff = fillBuffer(quadNormals);
	}


	private void setIndices()
	{
		short quadIndices[] =
			{
			    0, 1, 2, // triangle 1
			    2, 3, 0 // triangle 2
			};
		mIndBuff = fillBuffer(quadIndices);
		indicesNumber = quadIndices.length;
	}


	public int getNumObjectIndex()
	{
		return indicesNumber;
	}


	@Override
	public int getNumObjectVertex()
	{
		return verticesNumber;
	}


	@Override
	public Buffer getBuffer(BUFFER_TYPE bufferType)
	{
		Buffer result = null;
		switch (bufferType)
		{
		case BUFFER_TYPE_VERTEX:
			result = mVertBuff;
			break;
		case BUFFER_TYPE_TEXTURE_COORD:
			result = mTexCoordBuff;
			break;
		case BUFFER_TYPE_NORMALS:
			result = mNormBuff;
			break;
		case BUFFER_TYPE_INDICES:
			result = mIndBuff;
		default:
			break;

		}

		return result;
	}

}
