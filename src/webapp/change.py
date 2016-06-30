#codine utf-8
import sys
s=[]
filein = 'in.txt'
fileout = 'out.txt'

if __name__ == '__main__':
	filein=sys.argv[1]
	fileout=sys.argv[2]
	with open(fileout,'w') as fout:
		with open(filein,'r') as f:
			lines = f.readlines()
			for line in lines:
				s.append("\'"+line[0:-1]+"\'+")
		fout.writelines(('\n').join(s))