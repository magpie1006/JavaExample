package com.woniper.aws;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.amazonaws.services.s3.model.Bucket;

public class MainAWS {

	public static void main(String[] args) throws FileNotFoundException {

		S3Util s3 = new S3Util();
		
		List<Bucket> list = s3.getBucketList();
		
		// 첫번째 Bucket
		String bucketName = list.get(0).getName().toString();
		System.out.println("Bucket Name : " + bucketName);
		
		// Bucket 생성(대문자는 포함되면 안됨.)
		for(int i = 0; i < 3; i++) {
			s3.createBucket("wonier-test-bucket" + i);
		}
		
		// 폴더 생성
		for(int i = 0; i < 3; i++) {
			s3.createFolder(bucketName, "woniper-test-folder" + i);
		}
		
		// 파일 업로드
		String fileName = "/Users/woniper/Downloads/aws-java-sdk-1.8.4.zip";
		s3.fileUpload(bucketName, new File(fileName));
		System.out.println(s3.getFileURL(bucketName, "aws-java-sdk-1.8.4.zip"));
		
	}

}
